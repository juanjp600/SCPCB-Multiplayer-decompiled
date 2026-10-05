Function getsteamticket%()
    cancelsteamticket()
    steamauthtickethandle = steam_getauthsessionticket(steamauthticket, banksize(steamauthticket))
    steamauthticketsize = steam_getauthsessionticketsize()
    Return $00
End Function
