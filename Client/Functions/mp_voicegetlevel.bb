Function mp_voicegetlevel#()
    Local local0%
    Local local1#
    local0 = createbank($04)
    bass_channelgetlevelex(mp_voice\Field1, local0, 0.02, $11)
    local1 = peekfloat(local0, $00)
    freebank(local0)
    Return local1
    Return 0.0
End Function
