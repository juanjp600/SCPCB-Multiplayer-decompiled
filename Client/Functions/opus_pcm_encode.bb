Function opus_pcm_encode%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    If (opusencoder = $00) Then
        Return $00
    EndIf
    local0 = opus_get_default_frame_size()
    local1 = createbank(local0)
    local2 = opus_encode(opusencoder, arg0, local0, local1, banksize(local1))
    If (local2 <> $FFFFFFFF) Then
        resizebank(local1, local2)
    Else
        freebank(local1)
        local1 = $00
        Return $00
    EndIf
    Return local1
    Return $00
End Function
