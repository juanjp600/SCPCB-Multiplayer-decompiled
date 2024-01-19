Function initvariables%()
    Local local0%
    Local local1%
    If (server\Field5 = "") Then
        server\Field5 = ("SCP Server v" + mp_version)
    EndIf
    If (((server\Field7 = "") Or (server\Field7 = " ")) <> 0) Then
        server\Field7 = setrandomseed()
    EndIf
    server\Field8 = (Int limit2(limit((Float server\Field8), 1.0), 0.0))
    server\Field2 = (Int limit2(limit((Float server\Field2), 1.0), 0.0))
    server\Field10 = (Int limit2(limit((Float server\Field10), 1.0), 0.0))
    server\Field19 = (Int limit2(limit((Float server\Field19), 1.0), 0.0))
    server\Field21 = (Int limit2(limit((Float server\Field21), 1.0), 0.0))
    server\Field23 = (Int limit2(limit((Float server\Field23), 1.0), 0.0))
    server\Field15 = limit2(limit(server\Field15, 1.0), 0.0)
    server\Field13 = (Int limit2(limit((Float server\Field13), 300000.0), 0.0))
    server\Field22 = (Int limit2(limit((Float server\Field22), 3599999.0), 400000.0))
    server\Field1 = (Str limit2(limit((Float server\Field1), 65535.0), 80.0))
    server\Field32 = $BB80
    If (server\Field52 = $00) Then
        server\Field52 = $04
    EndIf
    server\Field52 = (Int (limit2(limit((Float server\Field52), 4.0), 1.0) - 1.0))
    If (server\Field55 = $00) Then
        server\Field55 = $04
    EndIf
    local0 = $00
    For local1 = $00 To $02 Step $01
        If (lower(server\Field26) = lower(getnamedifficulty(local1))) Then
            local0 = $01
            Exit
        EndIf
    Next
    If (local0 = $00) Then
        rcon_difficulty($00)
    EndIf
    If (0.0 = server\Field15) Then
        server\Field15 = rnd(0.0, 1.0)
    EndIf
    If (((server\Field18 < $01) Or (server\Field18 > $40)) <> 0) Then
        server\Field18 = $10
    EndIf
    If (server\Field13 < $1388) Then
        server\Field13 = $3A98
    EndIf
    server\Field53 = server\Field18
    server\Field57 = $01
    seedrnd(millisecs())
    fsound_init($1F40, $40, $00)
    Return $00
End Function
