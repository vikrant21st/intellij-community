// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package org.jetbrains.idea.devkit;

import com.intellij.ui.IconManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * NOTE THIS FILE IS AUTO-GENERATED
 * DO NOT EDIT IT BY HAND, run "Generate icon classes" configuration instead
 */
public final class DevKitIcons {
  private static @NotNull Icon load(@NotNull String path, int cacheKey, int flags) {
    return IconManager.getInstance().loadRasterizedIcon(path, DevKitIcons.class.getClassLoader(), cacheKey, flags);
  }
  /** 16x16 */ public static final @NotNull Icon Add_sdk = load("icons/add_sdk.svg", 603615666, 2);

  public static final class Gutter {
    /** 12x12 */ public static final @NotNull Icon DescriptionFile = load("icons/gutter/descriptionFile.svg", 1578827601, 2);
    /** 12x12 */ public static final @NotNull Icon Diff = load("icons/gutter/diff.svg", -168933920, 2);
    /** 12x12 */ public static final @NotNull Icon Plugin = load("icons/gutter/plugin.svg", 1125903772, 2);
    /** 12x12 */ public static final @NotNull Icon Properties = load("icons/gutter/properties.svg", -267792053, 2);
  }

  /** 16x16 */ public static final @NotNull Icon Sdk_closed = load("icons/sdk_closed.svg", -345689465, 2);
}
