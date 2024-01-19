Function voice_update%()
    voice_recording(voice_isrecording(), networkserver\Field26)
    voice_wave_update()
    voice_players_update()
    If (camera <> $00) Then
        allistenerupdate(camera)
    EndIf
    alupdate()
    Return $00
End Function
