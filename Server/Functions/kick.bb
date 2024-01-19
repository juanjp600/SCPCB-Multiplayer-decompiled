Function kick%(arg0%, arg1$)
    Local local0%
    Local local1.rockets
    Local local2.grenades
    Local local3.spawnpoint
    Local local4.items
    Local local5$
    If (getscripts() <> 0) Then
        public_inqueue($28, $00)
        public_addparam($00, (Str arg0), $01)
        public_addparam($00, arg1, $03)
        callback($00)
    EndIf
    If (arg1 <> "") Then
        addlog(arg1, $00, $01, $00)
    EndIf
    clearchatforplayer(arg0)
    For local0 = $01 To $FF Step $01
        If (player[arg0]\Field45[local0] <> Null) Then
            Delete player[arg0]\Field45[local0]
        EndIf
    Next
    For local0 = $01 To $1F Step $01
        If (player[arg0]\Field44[local0] <> Null) Then
            Delete player[arg0]\Field44[local0]
        EndIf
    Next
    For local0 = $01 To $1F Step $01
        If (player[arg0]\Field43[local0] <> Null) Then
            Delete player[arg0]\Field43[local0]
        EndIf
    Next
    For local1 = Each rockets
        If (local1\Field11 = arg0) Then
            freeentity(local1\Field1)
            Delete local1
        EndIf
    Next
    For local2 = Each grenades
        If (local2\Field14 = arg0) Then
            freeentity(local2\Field2)
            Delete local2
        EndIf
    Next
    For local3 = Each spawnpoint
        If (local3\Field0 = arg0) Then
            Delete local3
        EndIf
    Next
    For local4 = Each items
        If (((local4\Field22 = arg0) And (local4\Field22 <> $00)) <> 0) Then
            If (mp_isascp(player[arg0]\Field36) = $00) Then
                positionentity(local4\Field1, player[local4\Field22]\Field0, (player[local4\Field22]\Field1 + 0.7), player[local4\Field22]\Field2, $01)
                resetentity(local4\Field1)
                rotateentity(local4\Field1, 0.0, (entityyaw(player[local4\Field22]\Field62, $00) + rnd(-110.0, 110.0)), 0.0, $00)
                moveentity(local4\Field1, 0.0, -0.1, 0.1)
                local4\Field15 = $00
                local4\Field22 = $00
            Else
                removeitem(local4, $01)
            EndIf
        EndIf
    Next
    If (player[arg0]\Field64 <> $00) Then
        freeentity(player[arg0]\Field64)
        player[arg0]\Field64 = $00
    EndIf
    If (player[arg0]\Field62 <> $00) Then
        freeentity(player[arg0]\Field62)
        player[arg0]\Field62 = $00
    EndIf
    If (player[arg0]\Field63 <> $00) Then
        freeentity(player[arg0]\Field63)
        player[arg0]\Field63 = $00
    EndIf
    For local0 = $01 To player[arg0]\Field176 Step $01
        removebytestream(player[arg0]\Field175[local0])
    Next
    local5 = player[arg0]\Field67
    Delete player[arg0]
    server\Field11 = (server\Field11 - $01)
    If (server\Field11 = $00) Then
        If ((server\Field9 And (local5 <> "")) <> 0) Then
            shouldrestartserver = breach_isstarted()
            server\Field9 = $00
            server\Field26 = server\Field27
            selecteddifficulty = difficulties(getdiff(server\Field26))
            If (server\Field39 <> 0) Then
                server\Field9 = $01
            EndIf
        EndIf
        gameinfo\Field5\Field1 = $00
        gameinfo\Field5\Field4 = $00
        gameinfo\Field5\Field2 = $00
        gameinfo\Field5\Field6 = $00
        server\Field30 = $00
    EndIf
    server\Field11 = $00
    For local0 = $01 To server\Field18 Step $01
        If (player[local0] <> Null) Then
            server\Field11 = (server\Field11 + $01)
            playeroptimize[server\Field11] = player[local0]
        EndIf
    Next
    Return $00
End Function
