Function steam_api_setachievement%(arg0$)
    If (arg0 <> "") Then
        bs_isteamuserstats_setachievement(bs_steamuserstats(), arg0)
        bs_isteamuserstats_storestats(bs_steamuserstats())
    EndIf
    Return $00
End Function
