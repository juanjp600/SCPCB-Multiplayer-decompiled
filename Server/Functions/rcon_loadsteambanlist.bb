Function rcon_loadsteambanlist%(arg0$)
    Local local0%
    Local local1.banned
    local0 = readfile(arg0)
    If (local0 = $00) Then
        addlog("[WARNING][RCON] Local Steam banlist not loaded.", $00, $00, $00, $FF, $FF, $00)
        Return $00
    EndIf
    While (eof(local0) = $00)
        local1 = (New banned)
        local1\Field2 = (Int readline(local0))
    Wend
    addlog("[RCON] Local Steam banlist loaded successfully.", $00, $00, $00, $00, $FF, $00)
    closefile(local0)
    Return $00
End Function
