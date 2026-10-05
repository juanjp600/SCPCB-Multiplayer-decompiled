Function rcon_loadbanlist%(arg0$)
    Local local0%
    Local local1%
    Local local2.banned
    Local local3.cidrs
    local0 = readfile(arg0)
    If (local0 = $00) Then
        addlog("[WARNING][RCON] Local IP banlist not loaded.", $00, $00, $00, $FF, $FF, $00)
        Return $00
    EndIf
    While (eof(local0) = $00)
        local1 = (Int readline(local0))
        If (instr((Str local1), "/", $01) = $00) Then
            local2 = (New banned)
            local2\Field1 = (Str local1)
        Else
            local3 = (New cidrs)
            local3\Field0 = (Str local1)
        EndIf
    Wend
    addlog("[RCON] Local IP banlist loaded successfully.", $00, $00, $00, $00, $FF, $00)
    closefile(local0)
    Return $00
End Function
