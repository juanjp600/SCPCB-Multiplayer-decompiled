Function console_spawnnpc%(arg0%, arg1$, arg2$)
    Local local0.npcs
    Local local1$
    Select arg1
        Case "008","008zombie"
            local0 = createnpc($15, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local0\Field9 = 1.0
            local1 = "SCP-008 infected human spawned."
        Case "049","scp049","scp-049"
            local0 = createnpc($0A, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local0\Field9 = 1.0
            local1 = "SCP-049 spawned."
        Case "049-2","0492","scp-049-2","scp049-2","049zombie"
            local0 = createnpc($0B, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local0\Field9 = 1.0
            local1 = "SCP-049-2 spawned."
        Case "066","scp066","scp-066"
            local0 = createnpc($10, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "SCP-066 spawned."
        Case "096","scp096","scp-096"
            local0 = createnpc($09, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local0\Field9 = 5.0
            If (curr096 = Null) Then
                curr096 = local0
            EndIf
            local1 = "SCP-096 spawned."
        Case "106","scp106","scp-106","larry"
            local0 = createnpc($02, entityx(arg0, $00), (entityy(arg0, $00) - 0.5), entityz(arg0, $00))
            local0\Field9 = -1.0
            local1 = "SCP-106 spawned."
        Case "173","scp173","scp-173","statue"
            local0 = createnpc($01, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            curr173 = local0
            If (3.0 = curr173\Field24) Then
                curr173\Field24 = 0.0
            EndIf
            local1 = "SCP-173 spawned."
        Case "372","scp372","scp-372"
            local0 = createnpc($06, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "SCP-372 spawned."
        Case "513-1","5131","scp513-1","scp-513-1"
            local0 = createnpc($0C, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "SCP-513-1 spawned."
        Case "860-2","8602","scp860-2","scp-860-2"
        Case "939","scp939","scp-939"
        Case "966","scp966","scp-966"
            local0 = createnpc($12, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "SCP-966 instance spawned."
        Case "1048-a","scp1048-a","scp-1048-a","scp1048a","scp-1048a"
        Case "1499-1","14991","scp-1499-1","scp1499-1"
            local0 = createnpc($14, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "SCP-1499-1 instance spawned."
        Case "class-d","classd","d"
            local0 = createnpc($04, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "D-Class spawned."
        Case "guard"
            local0 = createnpc($03, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "Guard spawned."
        Case "mtf"
            local0 = createnpc($08, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "MTF unit spawned."
        Case "apache","helicopter"
            local0 = createnpc($07, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "Apache spawned."
        Case "tentacle"
            local0 = createnpc($0D, entityx(arg0, $00), entityy(arg0, $00), entityz(arg0, $00))
            local1 = "SCP-035 tentacle spawned."
        Case "clerk"
            local0 = createnpc($16, entityx(arg0, $00), (entityy(arg0, $00) + 0.2), entityz(arg0, $00))
            local1 = "Clerk spawned."
        Default
            Return $00
    End Select
    If (local0 <> Null) Then
        If (arg2 <> "") Then
            local0\Field9 = (Float arg2)
            local1 = (((local1 + " (State = ") + (Str local0\Field9)) + ")")
        EndIf
    EndIf
    Return $00
End Function
