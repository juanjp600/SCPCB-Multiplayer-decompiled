Function mp_client_receiveinteract%(arg0%)
    Local local0.events
    If (mp_events[arg0] = Null) Then
        Return $00
    EndIf
    local0 = mp_events[arg0]
    Select local0\Field0
        Case $17
            If (channelplaying(local0\Field6) <> 0) Then
                stopchannel(local0\Field6)
                local0\Field6 = $00
            EndIf
            snd_i\Field22 = loadsound_strict("SFX\Room\106Chamber\FemurBreaker.ogg")
            local0\Field6 = playsound_strict(snd_i\Field22, $01)
        Case $01
            If (0.0 = local0\Field3) Then
                local0\Field3 = (Float rand($01, $02))
            EndIf
    End Select
    Return $00
End Function
