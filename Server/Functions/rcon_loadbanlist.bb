Function rcon_loadbanlist%(arg0$)
    Local local0%
    Local local1.banned
    local0 = readfile(arg0)
    If (local0 = $00) Then
        consolelog("[RCON] IP Ban list not loaded.", $07)
        Return $00
    EndIf
    While (eof(local0) = $00)
        local1 = (New banned)
        local1\Field1 = readline(local0)
    Wend
    consolelog("[RCON] Ban IP list loaded successfully.", $07)
    closefile(local0)
    Return $00
End Function
