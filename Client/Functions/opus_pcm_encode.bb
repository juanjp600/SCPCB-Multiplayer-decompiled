Function opus_pcm_encode%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    If (opusencoder = $00) Then
        Return $00
    EndIf
    local0 = opus_get_default_frame_size()
    local1 = createbank(local0)
    If (local1 = $00) Then
        Return $00
    EndIf
    local2 = opus_encode(opusencoder, arg0, local0, local1, banksize(local1))
    If (((local2 > $00) And (local2 <= banksize(local1))) <> 0) Then
        resizebank(local1, local2)
    Else
        freebank(local1)
        Return $00
    EndIf
    Return local1
    Return $00
End Function
