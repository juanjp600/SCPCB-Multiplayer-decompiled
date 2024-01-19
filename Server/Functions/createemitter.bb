Function createemitter.emitters(arg0#, arg1#, arg2#, arg3%, arg4#)
    Local local0.emitters
    Local local2.rooms
    local0 = (New emitters)
    local0\Field0 = createpivot($00)
    nameentity(local0\Field0, "Emitter1")
    positionentity(local0\Field0, arg0, arg1, arg2, $01)
    Select arg3
        Case $00
            local0\Field1 = 0.03
            local0\Field4 = -0.2
            local0\Field5 = $C8
            local0\Field11 = 0.005
            local0\Field9 = 0.004
            local0\Field10 = 20.0
            local0\Field12 = -0.008
        Case $01
            local0\Field1 = 0.03
            local0\Field4 = -0.2
            local0\Field5 = $C8
            local0\Field11 = 0.008
            local0\Field9 = 0.004
            local0\Field10 = 40.0
            local0\Field12 = -0.01
            local0\Field2 = $06
            local0\Field3 = $06
    End Select
    local0\Field13 = arg4
    For local2 = Each rooms
        If (((4.0 > (Abs (entityx(local0\Field0, $00) - entityx(local2\Field2, $00)))) And (4.0 > (Abs (entityz(local0\Field0, $00) - entityz(local2\Field2, $00))))) <> 0) Then
            local0\Field7 = local2
        EndIf
    Next
    Return local0
    Return Null
End Function
