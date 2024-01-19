Function discord_api_update%()
    If (discord_inited <> 0) Then
        discord_update()
    EndIf
    Return $00
End Function
