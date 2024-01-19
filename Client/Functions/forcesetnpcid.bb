Function forcesetnpcid%(arg0.npcs, arg1%)
    Local local0.npcs
    arg0\Field6 = arg1
    For local0 = Each npcs
        If (((local0 <> arg0) And (local0\Field6 = arg1)) <> 0) Then
            local0\Field6 = findfreenpcid()
        EndIf
    Next
    Return $00
End Function
