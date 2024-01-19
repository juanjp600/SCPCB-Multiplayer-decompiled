Function console_spawnnpc%(arg0$, arg1$, arg2%)
    Local local0.npcs
    Local local1$
    Local local2%
    local2 = collider
    If (arg2 > $00) Then
        If (player[arg2] <> Null) Then
            local2 = player[arg2]\Field13
        EndIf
    EndIf
    Select arg0
        Case "008","008zombie"
            local0 = createnpc($15, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local0\Field9 = 1.0
            local1 = "SCP-008 infected human spawned."
        Case "049","scp049","scp-049"
            local0 = createnpc($0A, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local0\Field9 = 1.0
            local1 = "SCP-049 spawned."
        Case "049-2","0492","scp-049-2","scp049-2","049zombie"
            local0 = createnpc($0B, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local0\Field9 = 1.0
            local1 = "SCP-049-2 spawned."
        Case "066","scp066","scp-066"
            local0 = createnpc($10, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "SCP-066 spawned."
        Case "096","scp096","scp-096"
            local0 = createnpc($09, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local0\Field9 = 5.0
            If (curr096 = Null) Then
                curr096 = local0
            EndIf
            local1 = "SCP-096 spawned."
        Case "106","scp106","scp-106","larry"
            local0 = createnpc($02, entityx(local2, $00), (entityy(local2, $00) - 0.5), entityz(local2, $00))
            local0\Field9 = -1.0
            local1 = "SCP-106 spawned."
        Case "173","scp173","scp-173","statue"
            local0 = createnpc($01, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            curr173 = local0
            If (3.0 = curr173\Field24) Then
                curr173\Field24 = 0.0
            EndIf
            local1 = "SCP-173 spawned."
        Case "372","scp372","scp-372"
            local0 = createnpc($06, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "SCP-372 spawned."
        Case "513-1","5131","scp513-1","scp-513-1"
            local0 = createnpc($0C, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "SCP-513-1 spawned."
        Case "860-2","8602","scp860-2","scp-860-2"
            createconsolemsg("SCP-860-2 cannot be spawned with the console. Sorry!", $FF, $00, $00, $00)
        Case "939","scp939","scp-939"
            createconsolemsg("SCP-939 instances cannot be spawned with the console. Sorry!", $FF, $00, $00, $00)
        Case "966","scp966","scp-966"
            local0 = createnpc($12, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "SCP-966 instance spawned."
        Case "1048-a","scp1048-a","scp-1048-a","scp1048a","scp-1048a"
            createconsolemsg("SCP-1048-A cannot be spawned with the console. Sorry!", $FF, $00, $00, $00)
        Case "1499-1","14991","scp-1499-1","scp1499-1"
            local0 = createnpc($14, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "SCP-1499-1 instance spawned."
        Case "class-d","classd","d"
            local0 = createnpc($04, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "D-Class spawned."
        Case "guard"
            local0 = createnpc($03, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "Guard spawned."
        Case "mtf"
            local0 = createnpc($08, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "MTF unit spawned."
        Case "apache","helicopter"
            local0 = createnpc($07, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "Apache spawned."
        Case "tentacle"
            local0 = createnpc($0D, entityx(local2, $00), entityy(local2, $00), entityz(local2, $00))
            local1 = "SCP-035 tentacle spawned."
        Case "clerk"
            local0 = createnpc($16, entityx(local2, $00), (entityy(local2, $00) + 0.2), entityz(local2, $00))
            local1 = "Clerk spawned."
        Default
            createconsolemsg("NPC type not found.", $FF, $00, $00, $00)
            Return $00
    End Select
    If (local0 <> Null) Then
        If (arg1 <> "") Then
            local0\Field9 = (Float arg1)
            local1 = (((local1 + " (State = ") + (Str local0\Field9)) + ")")
        EndIf
    EndIf
    createconsolemsg(local1, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    Return $00
End Function
