Function changeresolution%(arg0%, arg1%)
    If (udp_getstream() <> 0) Then
        disconnectserver("", $00)
    EndIf
    putinivalue(optionfile, "options", "width", (Str arg0))
    putinivalue(optionfile, "options", "height", (Str arg1))
    If (fullscreensetting <> 0) Then
        putinivalue(optionfile, "options", "fullscreen", "true")
    Else
        putinivalue(optionfile, "options", "fullscreen", "false")
    EndIf
    If (launcherenabledsetting <> 0) Then
        putinivalue(optionfile, "launcher", "launcher enabled", "true")
    Else
        putinivalue(optionfile, "launcher", "launcher enabled", "false")
    EndIf
    If (borderlesswindowedsetting <> 0) Then
        putinivalue(optionfile, "options", "borderless windowed", "true")
    Else
        putinivalue(optionfile, "options", "borderless windowed", "false")
    EndIf
    If (bit16modesetting <> 0) Then
        putinivalue(optionfile, "options", "16bit", "true")
    Else
        putinivalue(optionfile, "options", "16bit", "false")
    EndIf
    putinivalue(optionfile, "options", "gfx driver new", (Str selectedgfxdriversetting))
    putinivalue(optionfile, "launcher", "changeres", "1")
    putinivalue(optionfile, "launcher", "isstarted", "0")
    endgraphics()
    If ((borderlesswindowedsetting Or fullscreensetting) <> 0) Then
        graphics3d(arg0, arg1, $00, $03)
        api_setwindowlong(g_app_handle, $FFFFFFF0, $80000000)
        api_setwindowpos(g_app_handle, $00, g_viewport_x, g_viewport_y, g_viewport_width, g_viewport_height, $40)
    Else
        aspectratioratio = 1.0
        realgraphicwidth = arg0
        realgraphicheight = arg1
        If (fullscreensetting <> 0) Then
            graphics3d(arg0, arg1, (bit16modesetting Shl $04), $01)
        Else
            graphics3d(arg0, arg1, $00, $02)
        EndIf
    EndIf
    clscolor($00, $00, $00)
    cls()
    flip($00)
    clscolor($00, $00, $00)
    cls()
    executeapp("game.exe")
    Repeat
        updateinifile(optionfile)
        If (getiniint(optionfile, "launcher", "isstarted", $00) = $01) Then
            putinivalue(optionfile, "launcher", "isstarted", "0")
            closegame()
        EndIf
        delay($0A)
    Forever
    Return $00
End Function
