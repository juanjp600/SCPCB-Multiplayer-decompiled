Function cleartexturecache%()
    Local local0.materials
    For local0 = Each materials
        If (local0\Field1 <> $00) Then
            freetexture(local0\Field1)
        EndIf
        If (local0\Field2 <> $00) Then
            freetexture(local0\Field2)
        EndIf
        Delete local0
    Next
    Return $00
End Function
