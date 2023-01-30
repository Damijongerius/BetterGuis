package com.me.dami.activabetterinterface.Permissions;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public class LuckPermManager {
    private static LuckPerms api;

    public LuckPermManager(){

        //get luckperms api
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
        }
    }

    public static boolean HasPermission(Player _p, String _name) {

        final boolean[] endResult = {false};

        api.getUserManager().loadUser(_p.getUniqueId())
                .thenApplyAsync(user -> {
                            Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
                            return inheritedGroups.stream().anyMatch(g -> g.getName().equals(_name));
                        }
                ).thenAccept(result -> {
                    endResult[0] = result;});
        return endResult[0];
    }

    public static boolean HasPermissions(Player _p, List<String> _perms) {

        final boolean[] results = {true};

        for (String perm : _perms) {
            api.getUserManager().loadUser(_p.getUniqueId())
                    .thenApplyAsync(user -> {
                                Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
                                return inheritedGroups.stream().anyMatch(g -> g.getName().equals(perm));
                            }

                    ).thenAccept(result -> {
                                if (results[0] == true && result == false) {
                                    results[0] = false;
                                }
                            }
                    );
        }

        return results[0];
    }

    public static boolean HasOneOfPermissions(Player _p, List<String> _perms) {

        final boolean[] endResult = {false};

        for (String perm : _perms) {
            api.getUserManager().loadUser(_p.getUniqueId())
                    .thenApplyAsync(user -> {
                                Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
                                return inheritedGroups.stream().anyMatch(g -> g.getName().equals(perm));
                            }

                    ).thenAccept(result -> {
                                if (result) {
                                    endResult[0] = true;
                                }
                            }
                    );
        }
        return endResult[0];
    }
}
