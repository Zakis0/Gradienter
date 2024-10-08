package com.example.gradienter.domain.usecase.gradientRepository

import com.example.gradienter.domain.repository.GradientRepository

class GetEditGradientItemUseCase(private val gradientRepository: GradientRepository) {
    operator fun invoke(editGradientItemId: String) =
        gradientRepository.getEditGradientItemUseCase(editGradientItemId = editGradientItemId)
}
