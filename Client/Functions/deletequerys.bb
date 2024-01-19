Function deletequerys%()
    Local local0.querys
    For local0 = Each querys
        closefile(local0\Field3)
        Delete local0
    Next
    Return $00
End Function
