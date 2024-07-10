package com.example.verticalslice.features.ingredients;

import java.util.List;
import java.util.UUID;

import com.example.pizza.Ingredient;
import com.example.segregation.Add;

public class AddIngredients {
    // Request->Input
    public record Request(
            String name,
            Double price)

    // Response->Output
    public record Response(
            UUID id,
            String name,
            Double price)
    }

    private final UseCase useCase;

    //Controller
    protected AddIngredients(final UseCase useCase) {
        this.useCase = useCase;
    }

    public Response add(Request req) {
        return useCase.add(req);
    }
    //endController

    // UseCase
    private interface UseCase {

        Response add(Request req);
    }

    private static class UseCaseImpl implements UseCase {

        private final Add<Ingredients> repository;

        public UseCaseImpl(final Add<Ingredients> repository) {
            this.repository = repository;
        }

        @Override
        public Response add(Request req) {

            //Request->Entidad
            
            var pizza = Ingredient.create(
                    req.name(),req.price());

            for (var ingr : req.ingredients()) {
                Ingredient.addIngredient(ingr);
            }
            //persistencia
            repository.add(Ingredient);
            //Entidad->Response
            return new Response(
                    ingredient.getId(),
                    ingredient.getName(),
                    ingredient.getPrice());
        }

    }
    //endUseCase

    // Repository
    private static class Repository implements Add<Ingredient> {

        @Override
        public void add(Ingredient entity) {
            // persistir la pizza
        }

    }
    //EndRepository

    //IOC->D(solid)
    public static AddIngredient build() {
        var repository = new Repository();
        var useCase = new UseCaseImpl(repository);
        return new AddIngredient(useCase);
    }
}

// Feature:AddIngredient->UseCase->Repository