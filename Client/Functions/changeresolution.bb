Function changeresolution%(arg0%, arg1%)
    Local local0%
    Local local1%
    If (udp_getstream() <> 0) Then
        disconnectserver("", $00)
    EndIf
    putinivalue("options.ini", "options", "width", (Str arg0))
    putinivalue("options.ini", "options", "height", (Str arg1))
    local0 = $02
    If (fullscreensetting <> 0) Then
        local0 = $01
        putinivalue("options.ini", "options", "fullscreen", "true")
    Else
        putinivalue("options.ini", "options", "fullscreen", "false")
    EndIf
    If (launcherenabledsetting <> 0) Then
        putinivalue("options.ini", "launcher", "launcher enabled", "true")
    Else
        putinivalue("options.ini", "launcher", "launcher enabled", "false")
    EndIf
    If (borderlesswindowedsetting <> 0) Then
        local0 = $05
        putinivalue("options.ini", "options", "borderless windowed", "true")
    Else
        putinivalue("options.ini", "options", "borderless windowed", "false")
    EndIf
    putinivalue("options.ini", "options", "gfx driver new", (Str selectedgfxdriversetting))
    putinivalue("options.ini", "launcher", "changeres", "1")
    putinivalue("options.ini", "launcher", "isstarted", "0")
    endgraphics()
    createwindow(arg0, arg1, $00, local0, "SCP - Containment Breach Multiplayer Mod ")
    setbuffer(backbuffer())
    clscolor($00, $00, $00, $FF)
    cls()
    flip($01)
    executeapp("game.exe")
    local1 = millisecs()
    Repeat
        If (getiniint("options.ini", "launcher", "isstarted", $00) = $01) Then
            putinivalue("options.ini", "launcher", "isstarted", "0")
            destroywindow()
        EndIf
        If ((millisecs() - local1) > $3E8) Then
            destroywindow()
        EndIf
        delay($0A)
    Forever
    Return $00
End Function
