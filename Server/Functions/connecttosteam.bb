Function connecttosteam%()
    Local local0%
    local0 = gs_init(iptodecimal(server\Field78), (Int server\Field1), (Int (server\Field1 + "1")), $01, mp_version)
    If (local0 <> $00) Then
        Repeat
            If (local0 = $00) Then
                Exit
            Else
                addlog((((("SteamGameServer failed to start. [ERROR- CODE: " + (Str local0)) + " | MSG: ") + gs_geterrormsg()) + "]"), $00, $00, $00, $C0, $C0, $C0)
                delay($BB8)
                local0 = gs_init($00, (Int server\Field1), (Int (server\Field1 + "1")), $01, mp_version)
            EndIf
        Forever
    EndIf
    gs_logon("1782380", server\Field5)
    Return $00
End Function
