Function updatemusic%()
    If (consoleflush <> 0) Then
        If (channelplaying(consolemusplay) = $00) Then
            consolemusplay = playsound(consolemusflush)
        EndIf
    ElseIf (playcustommusic = $00) Then
        If (nowplaying <> shouldplay) Then
            currmusicvolume = max((currmusicvolume - (fpsfactor / 250.0)), 0.0)
            If (((0.0 = currmusicvolume) Or (shouldplay = $1A)) <> 0) Then
                If (nowplaying < $42) Then
                    stopstream_strict(musicchn)
                EndIf
                nowplaying = shouldplay
                musicchn = $00
                currmusic = $00
            EndIf
        Else
            currmusicvolume = (((musicvolume - currmusicvolume) * (0.1 * fpsfactor)) + currmusicvolume)
        EndIf
        If (nowplaying < $42) Then
            If (currmusic = $00) Then
                musicchn = streamsound_strict((("SFX\Music\" + music(nowplaying)) + ".ogg"), 0.0, $02)
                currmusic = $01
            EndIf
            setstreamvolume_strict(musicchn, currmusicvolume)
        EndIf
    ElseIf (((0.0 < fpsfactor) Or (optionsmenu = $02)) <> 0) Then
        If (channelplaying(musicchn) = $00) Then
            musicchn = playsound_strict(custommusic)
        EndIf
        channelvolume(musicchn, (1.0 * musicvolume))
    EndIf
    Return $00
End Function
