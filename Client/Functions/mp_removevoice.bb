Function mp_removevoice%()
    Local local0%
    If (mp_voice = Null) Then
        Return $00
    EndIf
    freebank(mp_voice\Field3)
    mp_voice\Field3 = $00
    freebank(mp_voice\Field2)
    mp_voice\Field2 = $00
    opus_remove_encoder()
    bass_recordfree()
    Delete mp_voice
    Return $00
End Function
