Function voice_clear%(arg0%)
    Local local0%
    local0 = createbank(arg0)
    snd_in_read(voice\Field2, local0, arg0)
    freebank(local0)
    Return $00
End Function
