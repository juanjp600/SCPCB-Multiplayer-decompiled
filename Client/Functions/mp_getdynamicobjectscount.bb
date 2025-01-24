Function mp_getdynamicobjectscount%()
    Local local0%
    Local local1.mp_roomobject
    Local local2.mp_roomlever
    For local1 = Each mp_roomobject
        If (local1\Field15 <> 0) Then
            local0 = (local0 + $01)
        EndIf
    Next
    For local2 = Each mp_roomlever
        If (local2\Field9 <> 0) Then
            local0 = (local0 + $01)
        EndIf
    Next
    Return local0
    Return $00
End Function
