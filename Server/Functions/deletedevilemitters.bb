Function deletedevilemitters%()
    Local local0.devilemitters
    For local0 = Each devilemitters
        freeentity(local0\Field0)
        Delete local0
    Next
    Return $00
End Function
