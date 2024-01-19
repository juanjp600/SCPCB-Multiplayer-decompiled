Function requeststeamticket%()
    cancelsteamticket()
    Return bs_isteamuser_getauthsessionticket(bs_steamuser(), currentsessionticketdata, banksize(currentsessionticketdata), sessionticketsize)
    Return $00
End Function
