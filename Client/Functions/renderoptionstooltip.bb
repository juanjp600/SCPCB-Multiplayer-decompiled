Function renderoptionstooltip%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5#)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6$
    Local local7$
    Local local8%
    Local local9%
    Local local10%
    Local local13%
    Local local14%
    local0 = ((6.0 * menuscale) + (Float arg0))
    local1 = ((6.0 * menuscale) + (Float arg1))
    local2 = ((Float arg2) - (12.0 * menuscale))
    local3 = ((Float arg3) - (12.0 * menuscale))
    local4 = $00
    local5 = $00
    local6 = ""
    local7 = ""
    local8 = $00
    local9 = $00
    local10 = $00
    setfontex(fo\Field0[$00])
    color($FF, $FF, $FF)
    Select lower((Str arg4))
        Case "0"
            local6 = getlocalstring("tooltip", "bump")
            local8 = $FF
            local7 = getlocalstring("tooltip", "cantchange")
        Case "1"
            local6 = getlocalstring("tooltip", "vsync")
        Case "2"
            local6 = getlocalstring("tooltip", "alias")
            local8 = $FF
            local9 = $FF
            local7 = getlocalstring("tooltip", "fullscreen")
        Case "3"
            local6 = getlocalstring("tooltip", "lights")
        Case "4"
            local6 = getlocalstring("tooltip", "gamma")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.100"), (Str (Int (arg5 * 100.0))), "%s")
        Case "6"
            local6 = getlocalstring("tooltip", "particle_1")
            Select arg5
                Case 0.0
                    local8 = $FF
                    local7 = getlocalstring("tooltip", "particle_2.1")
                Case 1.0
                    local8 = $FF
                    local9 = $FF
                    local7 = getlocalstring("tooltip", "particle_2.2")
                Case 2.0
                    local9 = $FF
                    local7 = getlocalstring("tooltip", "particle_2.3")
            End Select
        Case "5"
            local6 = getlocalstring("tooltip", "lod")
        Case "7"
            local6 = getlocalstring("tooltip", "vram")
            local8 = $FF
            local7 = getlocalstring("tooltip", "cantchange")
        Case "8"
            local6 = getlocalstring("tooltip", "fov")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.fov"), (Str (Int opt\Field10)), "%s")
        Case "9"
            local6 = getlocalstring("tooltip", "anisotropic")
        Case "10"
            local6 = getlocalstring("tooltip", "screnderinterval")
        Case "12"
            local6 = getlocalstring("tooltip", "mastervolume")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.50"), (Str (Int (arg5 * 100.0))), "%s")
        Case "13"
            local6 = getlocalstring("tooltip", "musicvolume")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.50"), (Str (Int (arg5 * 100.0))), "%s")
        Case "14"
            local6 = getlocalstring("tooltip", "soundvolume")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.50"), (Str (Int (arg5 * 100.0))), "%s")
        Case "15"
            local6 = getlocalstring("tooltip", "voicevolume")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.50"), (Str (Int (arg5 * 100.0))), "%s")
        Case "16"
            local6 = getlocalstring("tooltip", "autorelease")
            local8 = $FF
            local7 = getlocalstring("tooltip", "cantchange")
        Case "17"
            local6 = getlocalstring("tooltip", "trackmode")
            local8 = $FF
            local9 = $FF
            local7 = getlocalstring("tooltip", "modenote")
        Case "18"
            local6 = getlocalstring("tooltip", "scantrack")
            local8 = $FF
            local7 = getlocalstring("tooltip", "cantchangebtn")
        Case "19"
            local6 = getlocalstring("tooltip", "subtitles")
        Case "20"
            local6 = getlocalstring("tooltip", "subtitles.color")
        Case "21"
            local6 = getlocalstring("tooltip", "mousespeed")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.0"), (Str (Int (arg5 * 100.0))), "%s")
        Case "23"
            local6 = getlocalstring("tooltip", "invertx")
        Case "24"
            local6 = getlocalstring("tooltip", "inverty")
        Case "22"
            local6 = getlocalstring("tooltip", "mousesmooth")
            local8 = $FF
            local9 = $FF
            local7 = format(getlocalstring("tooltip", "default.value.100"), (Str (Int (arg5 * 100.0))), "%s")
        Case "25"
            local6 = getlocalstring("tooltip", "configcontrol")
        Case "26"
            local6 = getlocalstring("tooltip", "hud")
        Case "27"
            local6 = format(getlocalstring("tooltip", "console"), key\Field0[key\Field5], "%s")
        Case "28"
            local6 = getlocalstring("tooltip", "errorconsole")
        Case "29"
            local6 = getlocalstring("tooltip", "achipop")
        Case "32"
            local6 = format(getlocalstring("tooltip", "autosave"), key\Field0[key\Field9], "%s")
            local8 = $FF
            local9 = $FF
            local7 = getlocalstring("tooltip", "autosave.note")
        Case "30"
            local6 = getlocalstring("tooltip", "fps")
        Case "31"
            local6 = getlocalstring("tooltip", "frame")
            If (((0.0 < arg5) And (60.0 > arg5)) <> 0) Then
                local8 = $FF
                local9 = $FF
                local7 = getlocalstring("tooltip", "frame.note")
            EndIf
        Case "33"
            local6 = getlocalstring("tooltip", "bar")
        Case "34"
            local6 = getlocalstring("tooltip", "vignette")
        Case "35"
            local6 = getlocalstring("tooltip", "startvideo")
        Case "36"
            local6 = getlocalstring("tooltip", "launcher")
        Case "37"
            local6 = getlocalstring("tooltip", "reset")
            local8 = $FF
            local7 = getlocalstring("tooltip", "cantchangebtn")
    End Select
    local4 = getlineamount(local6, (Int local2), (Int local3), 1.0)
    local13 = (stringheight(local6) * local4)
    local14 = (Int ((Float ($0A + local4)) * menuscale))
    If (local7 = "") Then
        renderframe(arg0, arg1, arg2, (local13 + local14), $00, $00, $00)
    Else
        local5 = getlineamount(local7, (Int local2), (Int local3), 1.0)
        renderframe(arg0, arg1, arg2, (Int ((Float ((local13 + local14) + (stringheight(local7) * local5))) + ((Float ($0A + local5)) * menuscale))), $00, $00, $00)
    EndIf
    rowtext(local6, (Int local0), (Int local1), (Int local2), (Int local3), $00, 1.0)
    If (local7 <> "") Then
        color(local8, local9, local10)
        rowtext(local7, (Int local0), (Int ((local1 + (Float local13)) + ((Float ($05 + local4)) * menuscale))), (Int local2), (Int local3), $00, 1.0)
        color($FF, $FF, $FF)
    EndIf
    Return $00
End Function
