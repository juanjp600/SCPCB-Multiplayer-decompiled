Function streamsound_strict%(arg0$, arg1#, arg2%)
    Local local0.stream
    Local local1%
    If (filetype(arg0) <> $01) Then
        Return $00
    EndIf
    local0 = (New stream)
    local0\Field0 = fsound_stream_open(arg0, arg2, $00, $00)
    If (local0\Field0 = $00) Then
        Return $00
    EndIf
    local0\Field1 = fsound_stream_play(local1, local0\Field0)
    If (local0\Field1 = $FFFFFFFF) Then
        Return $FFFFFFFF
    EndIf
    fsound_setvolume(local0\Field1, $00)
    fsound_setpaused(local0\Field1, $00)
    Return (Handle local0)
    Return $00
End Function
