Function steam_api_init%()
    Local local0%
    local0 = writefile("steam_appid.txt")
    writeline(local0, "1782380")
    closefile(local0)
    If (bs_steamapi_init() = $00) Then
        runtimeerror("Fatal Error - Steam must be running to play this game.")
    EndIf
    bs_isteamuserstats_requestcurrentstats(bs_steamuserstats())
    currentsteamid = bs_csteamid_getaccountid(bs_isteamuser_getsteamid(bs_steamuser()))
    currentsessionticketdata = createbank($400)
    sessionticketsize = createbank($04)
    steam_loadcallbacks()
    bs_isteamclient_setwarningmessagehook(bs_steamclient(), steam_warningmessagehook_callback)
    api_steamhtml = ((bs_steamhtmlsurface() <> $00) And (bs_isteamhtmlsurface_init(bs_steamhtmlsurface()) <> $00))
    Return $01
    Return $00
    Return $00
End Function
