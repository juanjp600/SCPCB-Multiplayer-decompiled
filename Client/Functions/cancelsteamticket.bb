Function cancelsteamticket%()
    If (steamauthtickethandle <> $00) Then
        steam_cancelauthticket(steamauthtickethandle)
        steamauthtickethandle = $00
    EndIf
    Return $00
End Function
