Function playerdead%(arg0%, arg1$)
    Local local0%
    If (server\Field21 <> 0) Then
        setplayertype(arg0, $00)
    EndIf
    player[arg0]\Field60 = 0.0
    player[arg0]\Field59 = $01
    player[arg0]\Field61 = 0.0
    player[arg0]\Field131 = $00
    If (arg1 <> "") Then
        If (getscripts() <> 0) Then
            local0 = public_inqueue($18, $00)
            public_addparam(local0, (Str arg0), $01)
            public_addparam(local0, (" " + arg1), $03)
            callback($00)
        EndIf
        If (se_return_value\Field8 = $00) Then
            If ((server\Field21 And (server\Field47 = $00)) <> 0) Then
                Return $00
            EndIf
            addlog(((player[arg0]\Field15 + " ") + arg1), $00, $01, $00)
        EndIf
    EndIf
    Return $00
End Function
