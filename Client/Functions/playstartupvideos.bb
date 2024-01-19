Function playstartupvideos%()
    Local local0$
    Local local1%
    Local local2%
    If (getiniint(optionfile, "options", "play startup video", $00) = $00) Then
        Return $00
    EndIf
    local0 = "GFX\menu\startup_Undertow"
    local1 = openmovie((local0 + ".avi"))
    local2 = streamsound_strict((local0 + ".ogg"), sfxvolume, $00)
    Repeat
        cls()
        drawmovie(local1, $00, $00, realgraphicwidth, realgraphicheight)
        flip($01)
    Until ((getkey() Or (isstreamplaying_strict(local2) = $00)) <> 0)
    stopstream_strict(local2)
    closemovie(local1)
    cls()
    flip($01)
    local0 = "GFX\menu\startup_TSS"
    local1 = openmovie((local0 + ".avi"))
    local2 = streamsound_strict((local0 + ".ogg"), sfxvolume, $00)
    Repeat
        cls()
        drawmovie(local1, $00, $00, realgraphicwidth, realgraphicheight)
        flip($01)
    Until ((getkey() Or (isstreamplaying_strict(local2) = $00)) <> 0)
    stopstream_strict(local2)
    closemovie(local1)
    cls()
    flip($01)
    Return $00
End Function
