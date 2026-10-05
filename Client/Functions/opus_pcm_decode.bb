Function opus_pcm_decode%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    If (arg0 = $00) Then
        Return $00
    EndIf
    If (((arg1 = $00) Or (banksize(arg1) < $01)) <> 0) Then
        Return $00
    EndIf
    local0 = createbank(((opus_get_default_frame_size() * opus_get_channels()) Shl $01))
    If (local0 = $00) Then
        Return $00
    EndIf
    local1 = opus_decode(arg0, arg1, banksize(arg1), local0, opus_get_default_frame_size(), arg2)
    If (((local1 <= $00) Or (local1 > opus_get_default_frame_size())) <> 0) Then
        freebank(local0)
        Return $00
    EndIf
    resizebank(local0, ((opus_get_channels() * local1) Shl $01))
    Return local0
    Return $00
End Function
