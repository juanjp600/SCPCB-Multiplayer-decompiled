Function playstartupvideos%()
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    Local local5$
    Local local6$
    If (shouldplaystartupvids = $00) Then
        Return $00
    EndIf
    local4 = $00
    Restore DATA_00001F40
    For local0 = $01 To $03 Step $01
        Read local1
        local5 = (("GFX\menu\" + local1) + ".webm")
        local6 = (("GFX\menu\" + local1) + ".ogg")
        local2 = openmovie(local5)
        If (local2 <> 0) Then
            local3 = streamsound_strict(local6, sfxvolume, $00)
            While (isstreamplaying_strict(local3) <> 0)
                drawmovie(local2, $00, $00, graphicwidth, graphicheight)
                flip($00)
                delay($0A)
                If ((getmouse() Or getkey()) <> 0) Then
                    local4 = $01
                    Exit
                EndIf
            Wend
            stopstream_strict(local3)
            closemovie(local2)
        EndIf
        If (local4 <> 0) Then
            Exit
        EndIf
    Next
    cls()
    flip($01)
    flushkeys()
    flushmouse()
    Return $00
End Function
