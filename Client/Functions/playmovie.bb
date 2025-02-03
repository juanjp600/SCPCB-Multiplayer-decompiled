Function playmovie%(arg0$)
    Local local0%
    Local local1#
    Local local2#
    Local local3%
    Local local4$
    Local local5$
    Local local6%
    Local local7%
    Local local8%
    If (runningonwine() <> 0) Then
        Return $00
    EndIf
    If (opt\Field40 = $00) Then
        Return $00
    EndIf
    hidepointer()
    fo\Field0[$00] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Default", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Default", "Size", "", $01)), $00, $00)
    local1 = (1.0 / 0.5625)
    local2 = (graphicwidthfloat / graphicheightfloat)
    If (local1 < local2) Then
        local0 = opt\Field50
    Else
        local0 = (Int ((Float opt\Field49) / local1))
    EndIf
    local5 = ("GFX\Menu\" + arg0)
    local6 = openmovie_strict((local5 + ".wmv"))
    local7 = streamsound_strict((local5 + ".ogg"), (opt\Field20 * opt\Field16), $00)
    Repeat
        cls()
        drawmovie(local6, $00, (mo\Field10 - (local0 Sar $01)), opt\Field49, local0)
        If (initializeintromovie <> 0) Then
            local4 = getlocalstring("menu", "wakeup")
        Else
            local4 = getlocalstring("menu", "anykey")
        EndIf
        renderloadingtext(mo\Field9, (Int ((Float opt\Field50) - (35.0 * menuscale))), local4, $01, $01)
        flip($01)
        local8 = $00
        If ((((getkey() <> $00) Lor mousehit($01)) Lor (isstreamplaying_strict(local7) = $00)) <> 0) Then
            resetloadingtextcolor()
            stopstream_strict(local7)
            local7 = $00
            closemovie(local6)
            local6 = $00
            local8 = $01
        EndIf
    Until (local8 <> 0)
    cls()
    flip($01)
    showpointer()
    Return $00
End Function
