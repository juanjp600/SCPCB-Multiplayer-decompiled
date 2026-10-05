Function rcon_globalloadbaniplist%(arg0%)
    Local local0%
    Local local1$
    Local local2.banned
    Local local3.cidrs
    local0 = openfile("player_cache\global\ipbanlist.dat")
    If (local0 = $00) Then
        addlog("[WARNING][RCON] Global IP banlist not loaded.", $00, $00, $00, $FF, $FF, $00)
        Return $00
    EndIf
    While (eof(local0) = $00)
        local1 = readline(local0)
        If (instr(local1, "/", $01) = $00) Then
            local2 = (New banned)
            local2\Field1 = local1
        Else
            local3 = (New cidrs)
            local3\Field0 = local1
        EndIf
    Wend
    If (arg0 <> 0) Then
        addlog("[RCON] Global IP banlist loaded successfully.", $00, $00, $00, $00, $FF, $00)
    EndIf
    closefile(local0)
    Return $00
End Function
