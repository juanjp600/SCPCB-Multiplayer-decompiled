Function initroomdoors%(arg0.rooms, arg1%)
    Local local0.roomsdoorsline
    For local0 = Each roomsdoorsline
        If (local0\Field0 <> Null) Then
            adddoortooptsystem(arg0, local0\Field0)
        EndIf
    Next
    Delete Each roomsdoorsline
    Return $00
End Function
