Function rcon_globalloadbansteamlist%(arg0%)
    Local local0%
    Local local1.banned
    local0 = openfile("player_cache\global\steambanlist.dat")
    If (local0 = $00) Then
        addlog("[WARNING][RCON] Global Steam banlist not loaded.", $00, $00, $00, $FF, $FF, $00)
        Return $00
    EndIf
    While (eof(local0) = $00)
        local1 = (New banned)
        local1\Field2 = (Int readline(local0))
    Wend
    If (arg0 <> 0) Then
        addlog("[RCON] Global Steam banlist loaded successfully.", $00, $00, $00, $00, $FF, $00)
    EndIf
    closefile(local0)
    Return $00
End Function
