Function cancelsteamticket%()
    If (currentsessionticket <> $00) Then
        bs_isteamuser_cancelauthticket(bs_steamuser(), currentsessionticket)
        currentsessionticket = $00
    EndIf
    Return $00
End Function
