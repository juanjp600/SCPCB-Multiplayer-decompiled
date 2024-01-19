Function rcon_findcmd$(arg0$)
    Local local0$
    Local local1%
    Local local2.rcon
    local0 = piece(arg0, $02, " ")
    local1 = $00
    For local2 = Each rcon
        If (local2\Field0 = local0) Then
            local1 = $01
            Exit
        EndIf
    Next
    If (local1 = $00) Then
        Return "Not found"
    EndIf
    Return local0
    Return ""
End Function
