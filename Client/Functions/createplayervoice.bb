Function createplayervoice%(arg0.mp_player)
    If (arg0\Field36 <> Null) Then
        Return $00
    EndIf
    arg0\Field36 = (New mp_playervoice)
    arg0\Field36\Field0[$00] = bass_opus_streamcreate(bass_createopusheader(opus_get_sample_rate(), opus_get_channels()), $08)
    arg0\Field36\Field0[$01] = bass_opus_streamcreate(bass_createopusheader(opus_get_sample_rate(), opus_get_channels()), $00)
    bass_channelplay(arg0\Field36\Field0[$00], $00)
    bass_channelplay(arg0\Field36\Field0[$01], $00)
    bass_fxsetdistortion(setplayervoicefx(arg0, $01, $02), -20.0, 300.0, 0.0, 4000.0, 4000.0)
    Return $00
End Function
