Function playsound_strict%(arg0%)
    Local local0.sounds
    Local local1%
    local0 = (Object.sounds arg0)
    If (local0 = Null) Then
        Return $00
    EndIf
    local1 = playsound(local0\Field0)
    channelvolume(local1, 0.0)
    Return local1
    Return $00
End Function
