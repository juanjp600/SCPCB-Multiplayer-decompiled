Function updatemusic%()
    If (nowplaying <> shouldplay) Then
        opt\Field19 = max((opt\Field19 - (fps\Field7[$00] / 250.0)), 0.0)
        If (0.0 = opt\Field19) Then
            If (nowplaying < $42) Then
                stopstream_strict(musicchn)
                musicchn = $00
            EndIf
            nowplaying = shouldplay
            currmusic = $00
        EndIf
    Else
        opt\Field19 = (((opt\Field18 - opt\Field19) * (fps\Field7[$00] * 0.1)) + opt\Field19)
    EndIf
    If (nowplaying < $42) Then
        If (currmusic = $00) Then
            musicchn = streamsound_strict((("SFX\Music\" + music[nowplaying]) + ".ogg"), 0.0, $01)
            currmusic = $01
        EndIf
        setstreamvolume_strict(musicchn, (opt\Field19 * opt\Field16))
    EndIf
    Return $00
End Function
