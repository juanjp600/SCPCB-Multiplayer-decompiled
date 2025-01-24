Function bass_opus_streamcreate%(arg0%, arg1%)
    Local local0%
    local0 = bass_opus_streamcreate_(arg0, arg1, $FFFFFFFF, $00)
    freebank(arg0)
    arg0 = $00
    Return local0
    Return $00
End Function
