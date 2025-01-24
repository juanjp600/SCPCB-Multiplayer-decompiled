Function mp_updatevoice%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (mp_voice = Null) Then
        Return $00
    EndIf
    local0 = bass_channelgetdata(mp_voice\Field1, mp_voice\Field2, $00)
    If (1.0 <= mp_getvoicetime(local0)) Then
        local1 = createbank((Int ((Float local0) * 1.25)))
        bass_channelgetdata(mp_voice\Field1, local1, banksize(local1))
        freebank(local1)
        local1 = $00
    EndIf
    If (mp_getvoicerecording() <> 0) Then
        resizebank(mp_voice\Field3, $00)
        If (bass_channelgetdata(mp_voice\Field1, mp_voice\Field2, $00) >= banksize(mp_voice\Field2)) Then
            bass_channelgetdata(mp_voice\Field1, mp_voice\Field2, banksize(mp_voice\Field2))
            local3 = opus_pcm_encode(mp_voice\Field2)
            If (local3 <> $00) Then
                pushbuffer(local3, $00, mp_voice\Field3, banksize(local3))
                freebank(local3)
                local3 = $00
            EndIf
        EndIf
    EndIf
    mp_netprocessvoice()
    Return $00
End Function
