Function steam_api_init%()
    Local local0%
    local0 = writefile("steam_appid.txt")
    writeline(local0, "1782380")
    closefile(local0)
    If (steam_restartappifnecessary($1B326C) <> 0) Then
        end()
    EndIf
    If (steam_init() <> $00) Then
        runtimeerror("Fatal Error - Steam must be running to play this game.")
    EndIf
    steamid64 = steam_idtostring(steam_getplayeridupper(), steam_getplayeridlower())
    steamauthticket = createbank($400)
    Return $01
    Return $00
    Return $00
End Function
