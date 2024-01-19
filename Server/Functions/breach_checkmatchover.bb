Function breach_checkmatchover%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7.breachtypes
    For local6 = $01 To server\Field11 Step $01
        If ((multiplayer_breach_isa035(playeroptimize[local6]\Field36) Or mp_isascp(playeroptimize[local6]\Field36)) <> 0) Then
            local3 = (local3 + $01)
        Else
            local7 = getbreachtype(playeroptimize[local6]\Field36)
            Select local7\Field60
                Case ntf_model
                    local0 = (local0 + $01)
                Case guard_model
                    local1 = (local1 + $01)
                Case janitor_model,scientist_model,worker_model,model_clerk
                    local2 = (local2 + $01)
                Case ntf_model
                    local0 = (local0 + $01)
                Case haos_model
                    local4 = (local4 + $01)
                Case classd_model
                    local5 = (local5 + $01)
            End Select
        EndIf
    Next
    If ((((local0 > $00) Or (local1 > $00)) Or (local2 > $00)) <> 0) Then
        If ((((local3 > $00) Or (local4 > $00)) Or (local5 > $00)) <> 0) Then
            Return $00
        ElseIf (((gameinfo\Field5\Field13 > $00) Or (gameinfo\Field5\Field15 > $00)) <> 0) Then
            Return $03
        Else
            Return $08
        EndIf
    ElseIf (local3 > $00) Then
        If (local5 > $00) Then
            Return $00
        ElseIf (((gameinfo\Field5\Field14 > $00) Or (gameinfo\Field5\Field12 > $00)) <> 0) Then
            Return $06
        Else
            Return $05
        EndIf
    ElseIf (((gameinfo\Field5\Field14 > $00) Or (gameinfo\Field5\Field12 > $00)) <> 0) Then
        Return $06
    Else
        Return $05
    EndIf
    Return $00
End Function
